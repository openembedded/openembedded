require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_pim_datebook.tar.bz2;name=split_core_pim_datebook \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_pim_datebook.md5sum] = "3b7308be8e905005f76a425dbc4915d1"
SRC_URI[split_core_pim_datebook.sha256sum] = "eb37678e6fcca265df23b13e50409e23c74169cb089fcdbf9a5acf47f52fbc60"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
