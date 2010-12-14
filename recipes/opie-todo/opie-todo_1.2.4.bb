require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_pim_todo.tar.bz2;name=split_core_pim_todo \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           file://unbreak-logging.patch"
SRC_URI[split_core_pim_todo.md5sum] = "dfd18603f0cf300d8c98a51b61a66390"
SRC_URI[split_core_pim_todo.sha256sum] = "bf8735c1b8271b85281500bcbdefecf5d9b4a80636cfb58478f619698783b99b"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
