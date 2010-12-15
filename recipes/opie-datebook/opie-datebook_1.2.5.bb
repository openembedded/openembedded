require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_pim_datebook.tar.bz2;name=split_core_pim_datebook \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_pim_datebook.md5sum] = "aef27444d5295f83d429ea8ab4c5d8b6"
SRC_URI[split_core_pim_datebook.sha256sum] = "170107bcdb13fac555128d3833edc8a166a770f43d2d5705306ed64cc17e2c5c"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
