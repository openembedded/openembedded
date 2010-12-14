require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_volumeapplet.tar.bz2;name=split_core_applets_volumeapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_volumeapplet.md5sum] = "5aa2d73a3ec24ff3084ab9357c3374c9"
SRC_URI[split_core_applets_volumeapplet.sha256sum] = "52ca512ff13497506e53c3a551a662a679b6326c97da7f411f6f97645cb926a3"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
