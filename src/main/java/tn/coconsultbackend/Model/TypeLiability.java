package tn.coconsultbackend.Model;

public enum TypeLiability {


    EQUITY {
        public enum SubType {
            SHARE,
            RESERVE,
            NETINCOME
        }
    },

    DEBTS {
        public enum SubType {
            SHORTTERM,
            LONGTERM
        }
    }
}
