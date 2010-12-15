require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_irdaapplet.tar.bz2;name=split_core_applets_irdaapplet \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_sounds.tar.bz2;name=split_sounds \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	  "
SRC_URI[split_core_applets_irdaapplet.md5sum] = "c25501ed8ebddf7106ee8ba36dc7a91e"
SRC_URI[split_core_applets_irdaapplet.sha256sum] = "9e44df950292cf9d47b226afdd4681ee8fadbc38cc0de8426d5a00fa01ff98de"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_sounds.md5sum] = "b0f2bee8c158f54162e5e74d4d9594df"
SRC_URI[split_sounds.sha256sum] = "55441675b28209cb2e34ffc0875c6d47aee27bd65dbdb40a223e5fa05c5a7c06"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
