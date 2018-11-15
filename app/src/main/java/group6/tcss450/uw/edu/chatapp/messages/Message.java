package group6.tcss450.uw.edu.chatapp.messages;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Message implements Serializable    {

    /**
     * The user the connection was established with.
     */
    private final String mUser;

    /**
     * The date the last message was received / sent.
     */
    private final String mDate;

    /**
     * The time the last message was received / sent.
     */
    private final String mTime;

    /**
     * The message itself.
     */
    private final String mMessage;

    private final int mChatId;

    public static class Builder {
        private final String mUser;
        private String mDate;
        private String mTime;
        private String mMessage = "";
        private int mChatId;

        /**
         * Constructor for message.
         *
         * @param theUser The user that sent the message.
         */
        public Builder(String theUser) {
            this.mUser = theUser;
        }

        public Builder addMessage(final String theMessage)    {
            this.mMessage = theMessage;
            return this;
        }

        public Builder addDate(final String theDate)    {
            this.mDate = theDate;
            return this;
        }

        public Builder addTime(final String theTime)    {
            this.mTime = theTime;
            return this;
        }

        public Builder addChatId(final int theId)   {
            this.mChatId = theId;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }

    private Message(final Builder builder) {
        this.mUser = builder.mUser;
        this.mDate = builder.mDate;
        this.mTime = builder.mTime;
        this.mMessage = builder.mMessage;
        this.mChatId = builder.mChatId;
    }

    public String getUser() {
        return mUser;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public String getMessage()  {
        return mMessage;
    }

    public int getChatId()   {
        return mChatId;
    }

    public String toString()    {
        return getUser() + " - " + getMessage();
    }

    public JSONObject asJSONObject()    {
        JSONObject msg = new JSONObject();
        try{
            msg.put("chatId", getChatId());
            msg.put("message", getMessage());
            msg.put("email", getUser());
        } catch (JSONException e)   {
            Log.wtf("MESSAGE", "Error creating Message JSON");
        }
        return msg;
    }
}

