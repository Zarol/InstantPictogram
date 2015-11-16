using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsClient.Messages
{
    class CreateUserMessage : Message
    {
        const String MESSAGE_TYPE = "CreateUser";
        const String USERNAME_KEY = "Username";
        const String PASSWORD_KEY = "Password";
        const String CREATED_KEY = "Created";
        
        public String Username
        {
            get { return username; }
            set { username = value; }
        }
        public String Password
        {
            get { return password; }
            set { password = value; }
        }
        public Boolean Created
        {
            get { return created; }
            set { created = value; }
        }

        String username;
        String password;
        Boolean created;

        public CreateUserMessage(String username, String password, Boolean created)
        {
            this.username = username;
            this.password = password;
            this.created = created;
        }

        public CreateUserMessage(JObject jobject)
        {
            JObject contents = JObject.Parse(jobject.GetValue(MESSAGE_TYPE).ToString());
            this.username = contents.GetValue(USERNAME_KEY).ToString();
            this.password = contents.GetValue(PASSWORD_KEY).ToString();
            this.created = Convert.ToBoolean(contents.GetValue(CREATED_KEY).ToString());
        }

        public JObject toJson()
        {
            JObject messageBuilder = new JObject();
            JObject thisBuilder = new JObject();
            thisBuilder.Add(USERNAME_KEY, this.username);
            thisBuilder.Add(PASSWORD_KEY, this.password);
            thisBuilder.Add(CREATED_KEY, this.created);

            messageBuilder.Add(MESSAGE_TYPE, thisBuilder);
            return messageBuilder;
        }

        public byte[] getMessageBytes()
        {
            ASCIIEncoding encoder = new ASCIIEncoding();
            return encoder.GetBytes(toJson().ToString(Formatting.None));
        }

        public int getMessageLength()
        {
            return getMessageBytes().Length;
        }
    }
}
