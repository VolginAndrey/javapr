using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using Microsoft.VisualBasic;

namespace ib_lab
{
    public partial class Form1 : Form
    {

        public class enc
        {

            string ab, key;
            public string[] input_text;

            public enc(string a, string k, string[] t) //инициализация класса с нужными значениями
            {
                ab = a;
                key = k;
                input_text = t;
            }

            public string XOR(string text, string key)
            {
                var result = new StringBuilder();
                for (int i = 0; i < text.Count(); i++)
                {
                    if (text[i] == '0' && key[i % (key.Count() - 1)] == '0')
                        result.Append('0');
                    else
                    if (text[i] == '1' && key[i % (key.Count() - 1)] == '0')
                        result.Append('1');
                    else
                    if (text[i] == '0' && key[i % (key.Count() - 1)] == '1')
                        result.Append('1');
                    else
                    if (text[i] == '1' && key[i % (key.Count() - 1)] == '1')
                        result.Append('0');
                    else
                        break;
                }


                return result.ToString();
            }

            public string[] cesar()
            {

                System.Int32 a; //проверка на значение ключа
                if (!Int32.TryParse(key, out a))
                {
                    MessageBox.Show("Для правильной работы этого алгоритма ключ должен быть числовым значением", "Ошибка", MessageBoxButtons.OK);
                    string[] answer = new string[1];
                    answer[0] = "";
                    return answer;
                }

                string[] output_text = new string[input_text.Length];

                for (int i = 0; i < input_text.Length; i++)
                {
                    string newline = "";
                    foreach (char sym in input_text[i])
                    {
                        int num, int_key = Int32.Parse(key);

                        for (num = 0; num < ab.Length; num++) //поиск символа в алфавите
                            if (ab[num] == sym) break;

                        if (num + int_key <= ab.Length - 1 && num + int_key >= 0) //если номер символа в границах алфавита
                            newline += ab[num + int_key];

                        else if (num + int_key < 0) //если номер отрицательный - идти с конца
                            newline += ab[ab.Length + int_key + num];

                        else //если номер больше размера алфавита - идти с начала
                            newline += ab[num + int_key - ab.Length];

                        output_text[i] = newline;
                    }
                }

                return output_text;

            }

            public string[] replace()
            {
                //проверка на соответствие алф. и ключа

                if (ab.Length != key.Length)
                {
                    MessageBox.Show("Длина алфавита и длина ключа не совпадает", "Ошибка", MessageBoxButtons.OK);
                    string[] answer = new string[1];
                    answer[0] = "";
                    return answer;
                }

                string[] output_text = new string[input_text.Length];

                for (int i = 0; i < input_text.Length; i++)
                {
                    string newline = "";
                    foreach (char sym in input_text[i])
                        if (ab.IndexOf(sym) == -1) newline += sym;
                        else newline += key[ab.IndexOf(sym)]; //замена символов в тексте на симв из ключа
                    output_text[i] = newline;
                }
                return output_text;
            }

            public string[] block_enc()
            {

                //проверка на значение ключа

                System.Int32 a;
                if (!Int32.TryParse(key, out a))
                {
                    MessageBox.Show("Для правильной работы этого алгоритма ключ должен быть числовым значением", "Ошибка", MessageBoxButtons.OK);
                    string[] answer = new string[1];
                    answer[0] = "";
                    return answer;
                }

                string[] output_text = new string[input_text.Length];
                int i, j;

                //парсим ключ

                int block_size = key.Length;
                int[] block_order = new int[block_size];
                for (i = 0; i < block_size; i++)
                    block_order[i] = (int)Char.GetNumericValue(key[i]);

                //конвертируем весь текст в одну строку

                string tmp_str_input_text = "";

                for (i = 0; i < input_text.Length; i++)
                    tmp_str_input_text += input_text[i] + ' ';

                int tail_l = tmp_str_input_text.Length % block_size;
                int enc_part_l = tmp_str_input_text.Length - tail_l;

                char[] str_input_text = new char[enc_part_l];
                char[] tail = new char[tail_l];

                for (i = 0; i < tmp_str_input_text.Length; i++)
                    if (i < enc_part_l)
                        str_input_text[i] = tmp_str_input_text[i];
                    else
                        tail[i - enc_part_l] = tmp_str_input_text[i];

                //основной алгоритм
                if (tmp_str_input_text.Length != block_size + 1)
                {
                    MessageBox.Show("Неверный ключ", "Ошибка", MessageBoxButtons.OK);
                    string[] answer = new string[1];
                    answer[0] = "";
                    return answer;
                }

                if (str_input_text.Last() == ' ')
                {
                    MessageBox.Show("Неверный ключ", "Ошибка", MessageBoxButtons.OK);
                    string[] answer = new string[1];
                    answer[0] = "";
                    return answer;
                }

                for (var t = 0; t < block_order.Length; t++)
                {
                    if (block_order[t] > str_input_text.Length)
                    {
                        MessageBox.Show("Ошибка в ключе", "Ошибка", MessageBoxButtons.OK);
                        string[] answer = new string[1];
                        answer[0] = "";
                        return answer;
                    }
                }
                for (i = 0; i < str_input_text.Length; i += block_size)
                {
                    char[] block = new char[block_size]; //массив под текущий блок
                    char[] temp_block = new char[block_size];

                    for (j = i; j < i + block_size; j++)
                        block[j - i] = str_input_text[j];

                    for (j = i; j < i + block_size; j++)
                        temp_block[j - i] = str_input_text[j];

                    for (j = 0; j < block_size; j++)
                        block[j] = temp_block[block_order[j] - 1];

                    output_text[0] += new string(block);
                }
                output_text[0] += new string(tail);
                return output_text;
            }

            public string[] hard_block_enc()
            {

                //проверка на значение ключа

                System.Int32 a;
                if (!Int32.TryParse(key, out a))
                {
                    MessageBox.Show("Для правильной работы этого алгоритма ключ должен быть числовым значением, не превышающим 9", "Ошибка", MessageBoxButtons.OK);
                    string[] answer = new string[1];
                    answer[0] = "";
                    return answer;
                }

                string[] output_text = new string[512];
                int i, j;

                //парсим ключ

                int block_size = key.Length;
                int[] block_order = new int[block_size];
                for (i = 0; i < block_size; i++)
                    block_order[i] = (int)Char.GetNumericValue(key[i]);

                //конвертируем весь текст в одну строку

                string tmp_str_input_text = "";

                for (i = 0; i < input_text.Length; i++)
                    tmp_str_input_text += input_text[i] + ' ';

                int tail_l = tmp_str_input_text.Length % block_size;
                int enc_part_l = tmp_str_input_text.Length - tail_l;

                char[] str_input_text = new char[enc_part_l];
                char[] tail = new char[tail_l];

                for (i = 0; i < tmp_str_input_text.Length; i++)
                    if (i < enc_part_l)
                        str_input_text[i] = tmp_str_input_text[i];
                    else
                        tail[i - enc_part_l] = tmp_str_input_text[i];

                //основной алгоритм

                int k = 0;

                for (i = 0; i < str_input_text.Length; i += block_size)
                {
                    char[] block = new char[block_size]; //массив под текущий блок
                    char[] temp_block = new char[block_size];

                    for (j = i; j < i + block_size; j++)
                        block[j - i] = str_input_text[j];

                    for (j = i; j < i + block_size; j++)
                        temp_block[j - i] = str_input_text[j];

                    for (j = 0; j < block_size; j++)
                        block[j] = temp_block[block_order[j] - 1];

                    if (k % 2 != 0) Array.Reverse(block);
                    output_text[k] = new string(block);
                    k++;
                }

                if (k % 2 != 0) Array.Reverse(tail);
                output_text[k] = new string(tail); //перевернуть строку слева направо
                return output_text;
            }

        }

        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void load_text_from_file_Click(object sender, EventArgs e)
        {

            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "Text Files (.txt)|*.txt|All Files (*.*)|*.*";
            openFileDialog1.FilterIndex = 1;
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                input_text.Lines = File.ReadAllLines(openFileDialog1.FileName);
            }
            //string filepath = Interaction.InputBox("Загрузка исходного текста из файла", "Файл:", "");
            //if (filepath != "")
            //input_text.Lines = File.ReadAllLines(filepath);
        }

        private void load_ab_from_file_Click(object sender, EventArgs e)
        {
            string filepath = Interaction.InputBox("Загрузка алфавита из файла", "Файл:", "");
            if (filepath != "" && File.ReadAllLines(filepath).Count() == 1)
                ab.Lines = File.ReadAllLines(filepath);
        }

        private void load_key_from_file_Click(object sender, EventArgs e) //загрузка ключа из файла - событие на кнопке
        {
            string filepath = Interaction.InputBox("Загрузка ключа из файла", "Файл:", "");
            if (filepath != "" && File.ReadAllLines(filepath).Count() == 1)
                key.Lines = File.ReadAllLines(filepath);
        }

        private void encrypt_Click(object sender, EventArgs e) //клик по кнопке "зашифр"
        {

            //перевод всего текста в нижний регистр, чтоб не вылетало тк нету нужных симв в алф

            for (int i = 0; i < input_text.Lines.Length; i++) input_text.Lines[i] = input_text.Lines[i].ToLower(); //все в нижний регистр, чтоб не вылетало
            enc ENC = new enc(ab.Text.ToLower(), key.Text.ToLower(), input_text.Lines);
            if (input_text.Text != "" && ab.Text != "" && key.Text != "")
                switch (method.SelectedIndex)
                {
                    case 0:
                        encrypted_text.Lines = ENC.replace();
                        break;

                    case 1:
                        encrypted_text.Lines = ENC.block_enc();
                        break;

                    case 2:
                        encrypted_text.Lines = ENC.hard_block_enc();
                        break;
                    case 3:
                        encrypted_text.Lines = ENC.cesar();
                        break;
                    case 4:
                        for (var i = 0; i < input_text.Text.Length; i++)
                        {
                            if ((input_text.Text[i] > '1') || (input_text.Text[i] < '0'))
                            {
                                MessageBox.Show("Некорректный исходный текст", "Ошибка");
                                return;
                            }

                        }
                        for (var i = 0; i < key.Text.Length; i++)
                        {
                            if ((Convert.ToInt32(key.Text[i]) > '1') || (Convert.ToInt32(key.Text[i]) < '0'))
                            {
                                MessageBox.Show("Некорректный ключ", "Ошибка");
                                return;
                            }

                        }
                        encrypted_text.Text = ENC.XOR(input_text.Text, key.Text);
                        break;
                }


        }

        private void button2_Click(object sender, EventArgs e) //топовая расшифровка
        {
            encrypted_text.Lines = input_text.Lines;
        }

        private void method_SelectedIndexChanged(object sender, EventArgs e) //отключать поле с алфавитом, если выбраны блок, усл блок или xor - там он не нужен
        {
            encrypted_text.Text = "";
            if (
                method.SelectedIndex == 1 || //блок
                method.SelectedIndex == 2 || //усл блок
                method.SelectedIndex == 4    //XOR
               ) ab.Enabled = false;
            else ab.Enabled = true;

            key.Text = ""; //сброс значения ключа
        }

        private void keylabel_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }
    }
}