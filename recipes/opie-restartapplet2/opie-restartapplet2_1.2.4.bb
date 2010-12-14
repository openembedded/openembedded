require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_restartapplet2.tar.bz2;name=split_core_applets_restartapplet2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_restartapplet2.md5sum] = "f5fd17dd842e82b363589b99277fad60"
SRC_URI[split_core_applets_restartapplet2.sha256sum] = "60edd22042227fd95e07a240d4e7b3cd1f606c5307b17c6e4da6141904a0fa38"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
