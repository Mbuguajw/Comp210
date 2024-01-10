package a8;

import java.util.*;

public class PasswordManager<K, V> implements Map<K, V> {
    private static final String MASTER_PASSWORD = "OnePieceIsReal123";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }

    // TODO: put
    @Override
    public void put(K key, V value) {
        Account<K, V> newItem = new Account<>(key, value);
        int index = Math.abs(key.hashCode()) % this._passwords.length;
        if (this._passwords[index] == null) {
            this._passwords[index] = newItem;
        } else if (this._passwords[index].getWebsite().equals(key)) {
            this._passwords[index].setPassword(value);
        } else {
            Account<K, V> websiteIterator = this._passwords[index];
            while (websiteIterator != null) {
                if (websiteIterator.getWebsite().equals(key)) {
                    websiteIterator.setPassword(value);
                    break;
                }
                if (websiteIterator.getNext() == null) {
                    websiteIterator.setNext(newItem);
                    break;
                }
                websiteIterator = websiteIterator.getNext();
            }
        }
        System.out.println(this._passwords);
        System.out.println(this.keySet());
    }

    // TODO: get
    @Override
    public V get(K key) { //what if key doesn't exist?
        int index = Math.abs(key.hashCode()) % this._passwords.length;
        V gettingPassword = null;
        Account websiteIterator = this._passwords[index];
        while (websiteIterator.getNext() != null) {
            if (websiteIterator.getWebsite() == key) {
                gettingPassword = (V) websiteIterator.getPassword();
                break;
            } else {
                gettingPassword = null;
            }
            websiteIterator = websiteIterator.getNext();
        }
        return gettingPassword;
    }

    // TODO: size
    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < this._passwords.length; i++) {
            if (this._passwords[i].getWebsite() != null) {
                Account websiteIterator = this._passwords[i];
                counter += 1;
                while (websiteIterator.getNext() != null) {
                    counter += 1;
                    websiteIterator = websiteIterator.getNext();
                }
            }
        }
        return counter;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        Set<K> websitesSet = new HashSet<>();
        for (int i = 0; i < this._passwords.length; i++) {
            if (this._passwords[i] != null) {
                Account websiteIterator = this._passwords[i];
                while (websiteIterator.getNext() != null) {
                    websitesSet.add((K) websiteIterator.getWebsite());
                    websiteIterator = websiteIterator.getNext();
                }
            }

        }
        return websitesSet;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        V redacted = null;
        int index = Math.abs(hashCode()) % this._passwords.length;
        if (this._passwords[index] == null) {
            return null;
        } else if (this._passwords[index].getWebsite().equals(key)) {
            this._passwords[index] = this._passwords[index].getNext();
            redacted = (V) this._passwords[index].getPassword();
        } else {
            Account websiteIterator = this._passwords[index];
            while (!websiteIterator.getNext().equals(null)) {
                if (websiteIterator.getNext().getWebsite() == key) {
                    redacted = (V) this._passwords[index].getNext().getPassword();
                    Account tailPiece = websiteIterator.getNext().getNext();
                    websiteIterator.setNext(tailPiece);
                    break;
                }
                websiteIterator = websiteIterator.getNext();
            }
        }
        return redacted;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        int index = Math.abs(hashCode()) % this._passwords.length;
        List<K> duplicateList = new ArrayList<>();
        Account websiteIterator = this._passwords[index];
        while (websiteIterator.getNext() != null) {
            if (websiteIterator.getPassword().equals(value)) {
                duplicateList.add((K) websiteIterator.getWebsite());
            }
            websiteIterator = websiteIterator.getNext();
        }
        return duplicateList;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        if (this.MASTER_PASSWORD.equals(enteredPassword)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
