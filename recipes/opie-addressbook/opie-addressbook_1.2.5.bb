require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_pim_addressbook.tar.bz2;name=split_core_pim_addressbook \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_pim_addressbook.md5sum] = "3f3c8d0fc393ec645e4c6ab7eaea6bbb"
SRC_URI[split_core_pim_addressbook.sha256sum] = "350d9d7bb2eba671d953efc4c89c70b0fcb7bd21b84e82a1c90d0fdbeca6425d"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
