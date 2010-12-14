require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_restartapplet.tar.bz2;name=split_core_applets_restartapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_restartapplet.md5sum] = "04a5fee89a2c17fc1a6d6c8b51a9737e"
SRC_URI[split_core_applets_restartapplet.sha256sum] = "ef7828f181ae255a904b393655ffbbbc28ce4eeaec53437767aa8b023016dd76"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
