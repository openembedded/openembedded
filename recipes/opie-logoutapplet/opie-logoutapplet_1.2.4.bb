require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_logoutapplet.tar.bz2;name=split_core_applets_logoutapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_logoutapplet.md5sum] = "ab474fede185a3cdc2278a5df12f9340"
SRC_URI[split_core_applets_logoutapplet.sha256sum] = "8bc97a40da1e71a66dabe8a621dc0adc582d30c0293ef5a159dec8991457b85d"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
