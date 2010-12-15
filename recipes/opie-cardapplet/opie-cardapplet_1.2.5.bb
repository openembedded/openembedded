require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_applets_cardapplet.tar.bz2;name=split_noncore_applets_cardapplet \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_sounds.tar.bz2;name=split_sounds \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.5-split_etc.tar.bz2;name=split_etc"
SRC_URI[split_noncore_applets_cardapplet.md5sum] = "c663047085691dd3e57e7aa0bba89e4c"
SRC_URI[split_noncore_applets_cardapplet.sha256sum] = "053b798624bcbd1caf4307a6a1992a1e193ceb737bd045dd8a6e7a92a20d346f"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_sounds.md5sum] = "b0f2bee8c158f54162e5e74d4d9594df"
SRC_URI[split_sounds.sha256sum] = "55441675b28209cb2e34ffc0875c6d47aee27bd65dbdb40a223e5fa05c5a7c06"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_etc.md5sum] = "74ef523ef12e242155bbb745072434d9"
SRC_URI[split_etc.sha256sum] = "eef55ea2248b4f45f3a07beb6012e431dd71d4eefa134d39cc50b4d194c53087"
