namespace ib_lab
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.input_text = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.key = new System.Windows.Forms.TextBox();
            this.method = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.encrypted_text = new System.Windows.Forms.TextBox();
            this.encrypt = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.load_ab_from_file = new System.Windows.Forms.Button();
            this.load_text_from_file = new System.Windows.Forms.Button();
            this.keylabel = new System.Windows.Forms.Label();
            this.ab = new System.Windows.Forms.TextBox();
            this.button3 = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // input_text
            // 
            this.input_text.Font = new System.Drawing.Font("Courier New", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.input_text.Location = new System.Drawing.Point(25, 221);
            this.input_text.Multiline = true;
            this.input_text.Name = "input_text";
            this.input_text.Size = new System.Drawing.Size(300, 215);
            this.input_text.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(22, 198);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(92, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Входящий текст:";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(46, 35);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(107, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Исходный алфавит:";
            // 
            // key
            // 
            this.key.Font = new System.Drawing.Font("Courier New", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.key.Location = new System.Drawing.Point(25, 128);
            this.key.Name = "key";
            this.key.Size = new System.Drawing.Size(300, 20);
            this.key.TabIndex = 3;
            // 
            // method
            // 
            this.method.Font = new System.Drawing.Font("Courier New", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.method.FormattingEnabled = true;
            this.method.Items.AddRange(new object[] {
            "Простая подстановка",
            "Блочная перестановка",
            "Усложненная блочная перестановка (змейка)",
            "Шифр Цезаря",
            "XOR"});
            this.method.Location = new System.Drawing.Point(471, 61);
            this.method.Name = "method";
            this.method.Size = new System.Drawing.Size(295, 22);
            this.method.TabIndex = 4;
            this.method.SelectedIndexChanged += new System.EventHandler(this.method_SelectedIndexChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(640, 35);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(126, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Алгоритм шифрования:";
            // 
            // encrypted_text
            // 
            this.encrypted_text.Font = new System.Drawing.Font("Courier New", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.encrypted_text.Location = new System.Drawing.Point(489, 221);
            this.encrypted_text.Multiline = true;
            this.encrypted_text.Name = "encrypted_text";
            this.encrypted_text.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.encrypted_text.Size = new System.Drawing.Size(300, 215);
            this.encrypted_text.TabIndex = 6;
            // 
            // encrypt
            // 
            this.encrypt.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.encrypt.Location = new System.Drawing.Point(331, 221);
            this.encrypt.Name = "encrypt";
            this.encrypt.Size = new System.Drawing.Size(147, 36);
            this.encrypt.TabIndex = 7;
            this.encrypt.Text = "Зашифровать";
            this.encrypt.UseVisualStyleBackColor = true;
            this.encrypt.Click += new System.EventHandler(this.encrypt_Click);
            // 
            // button2
            // 
            this.button2.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold);
            this.button2.Location = new System.Drawing.Point(331, 408);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(147, 28);
            this.button2.TabIndex = 8;
            this.button2.Text = "Расшифровать";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // load_ab_from_file
            // 
            this.load_ab_from_file.Font = new System.Drawing.Font("Microsoft Sans Serif", 6F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.load_ab_from_file.Location = new System.Drawing.Point(355, 66);
            this.load_ab_from_file.Name = "load_ab_from_file";
            this.load_ab_from_file.Size = new System.Drawing.Size(51, 17);
            this.load_ab_from_file.TabIndex = 9;
            this.load_ab_from_file.Text = "Файл...";
            this.load_ab_from_file.UseVisualStyleBackColor = true;
            this.load_ab_from_file.Visible = false;
            this.load_ab_from_file.Click += new System.EventHandler(this.load_ab_from_file_Click);
            // 
            // load_text_from_file
            // 
            this.load_text_from_file.Font = new System.Drawing.Font("Microsoft Sans Serif", 6F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.load_text_from_file.Location = new System.Drawing.Point(274, 198);
            this.load_text_from_file.Name = "load_text_from_file";
            this.load_text_from_file.Size = new System.Drawing.Size(51, 17);
            this.load_text_from_file.TabIndex = 10;
            this.load_text_from_file.Text = "Файл...";
            this.load_text_from_file.UseVisualStyleBackColor = true;
            this.load_text_from_file.Visible = false;
            this.load_text_from_file.Click += new System.EventHandler(this.load_text_from_file_Click);
            // 
            // keylabel
            // 
            this.keylabel.AutoSize = true;
            this.keylabel.Location = new System.Drawing.Point(46, 98);
            this.keylabel.Name = "keylabel";
            this.keylabel.Size = new System.Drawing.Size(36, 13);
            this.keylabel.TabIndex = 11;
            this.keylabel.Text = "Ключ:";
            this.keylabel.Click += new System.EventHandler(this.keylabel_Click);
            // 
            // ab
            // 
            this.ab.Font = new System.Drawing.Font("Courier New", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.ab.Location = new System.Drawing.Point(25, 63);
            this.ab.Name = "ab";
            this.ab.Size = new System.Drawing.Size(300, 20);
            this.ab.TabIndex = 12;
            this.ab.Text = "abcdefghijklmnopqrstuvwxyz";
            // 
            // button3
            // 
            this.button3.Font = new System.Drawing.Font("Microsoft Sans Serif", 6F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.button3.Location = new System.Drawing.Point(355, 128);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(51, 17);
            this.button3.TabIndex = 13;
            this.button3.Text = "Файл...";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Visible = false;
            this.button3.Click += new System.EventHandler(this.load_key_from_file_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(486, 198);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(123, 13);
            this.label4.TabIndex = 14;
            this.label4.Text = "Зашифрованный текст";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Highlight;
            this.ClientSize = new System.Drawing.Size(816, 464);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.ab);
            this.Controls.Add(this.keylabel);
            this.Controls.Add(this.load_text_from_file);
            this.Controls.Add(this.load_ab_from_file);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.encrypt);
            this.Controls.Add(this.encrypted_text);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.method);
            this.Controls.Add(this.key);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.input_text);
            this.Name = "Form1";
            this.Text = "Игра";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox input_text;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox key;
        private System.Windows.Forms.ComboBox method;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox encrypted_text;
        private System.Windows.Forms.Button encrypt;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button load_ab_from_file;
        private System.Windows.Forms.Button load_text_from_file;
        private System.Windows.Forms.Label keylabel;
        private System.Windows.Forms.TextBox ab;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Label label4;
    }
}

