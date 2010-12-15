require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_logoutapplet.tar.bz2;name=split_core_applets_logoutapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_logoutapplet.md5sum] = "035cbe9af480e8c468bcb656493e47e9"
SRC_URI[split_core_applets_logoutapplet.sha256sum] = "00dc7f476e5e5c9a6715b43afd66ddafc2c19eef47eb509bc5f1c1d289d2bb72"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
