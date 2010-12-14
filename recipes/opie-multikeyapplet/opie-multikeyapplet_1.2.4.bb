require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_multikeyapplet.tar.bz2;name=split_core_applets_multikeyapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_multikeyapplet.md5sum] = "33d099206151cec653491033ce0fc5f6"
SRC_URI[split_core_applets_multikeyapplet.sha256sum] = "598576acef4f87dbe55d4fdbe6d0ba5fa9a65ae1ab40b9362c86087a111e1c9a"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
