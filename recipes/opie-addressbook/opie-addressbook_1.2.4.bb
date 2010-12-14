require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_pim_addressbook.tar.bz2;name=split_core_pim_addressbook \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_pim_addressbook.md5sum] = "34e616179374a04a75e579e4d174daec"
SRC_URI[split_core_pim_addressbook.sha256sum] = "f13d5f0933d78d57edb25b565ab667ff3feb5dedf90431ce64e3d69131f22060"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
