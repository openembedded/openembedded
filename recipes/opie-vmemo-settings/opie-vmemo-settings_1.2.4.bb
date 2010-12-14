require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_sound.tar.bz2;name=split_noncore_settings_sound \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_settings_sound.md5sum] = "bc498d9dd35e0bacf45a0e76fddbe373"
SRC_URI[split_noncore_settings_sound.sha256sum] = "f8b1381d190afc0ee43e7b9cb57ab6130a126933bdba62901141c0d0fffddbfa"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
