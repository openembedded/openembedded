require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_suspendapplet.tar.bz2;name=split_core_applets_suspendapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_suspendapplet.md5sum] = "b26f66ee3fafb2b86e7f41f0c1caa8bc"
SRC_URI[split_core_applets_suspendapplet.sha256sum] = "cf138f79b2b0b0a10356c0d42d2eb5cb434fe2a04618486f7a990e8a959a7d78"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
