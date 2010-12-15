require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_net_mail.tar.bz2;name=split_noncore_net_mail \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_mail.md5sum] = "7f5ecde1c30af35ed34b272f7af07874"
SRC_URI[split_noncore_net_mail.sha256sum] = "6bac2a5da02faa84c533c26406c15acfc50c40882e676eb92f577b56b1203045"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
