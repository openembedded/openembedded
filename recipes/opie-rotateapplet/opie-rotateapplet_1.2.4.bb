require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_rotateapplet.tar.bz2;name=split_core_applets_rotateapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_rotateapplet.md5sum] = "4c71c12a0927b997b22a0a9c3ba181a8"
SRC_URI[split_core_applets_rotateapplet.sha256sum] = "04901177b3a68aa65ca5b7a662a16f61890f5cfbb01f8695b96c9f3f9ef33a5f"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
