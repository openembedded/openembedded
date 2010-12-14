require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_vtapplet.tar.bz2;name=split_core_applets_vtapplet \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_vtapplet.md5sum] = "bdffeace0c551a9cc5844faab5676a65"
SRC_URI[split_core_applets_vtapplet.sha256sum] = "16054f4bb21bf2918e486691354c4bda1e411257fe3fd66b6aa5e230beedbbf8"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
