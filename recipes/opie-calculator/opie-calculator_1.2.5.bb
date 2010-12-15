require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_tools_calculator.tar.bz2;name=split_noncore_tools_calculator \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.5-split_etc.tar.bz2;name=split_etc"
SRC_URI[split_noncore_tools_calculator.md5sum] = "fc16a420e33265aa21a4e8cc246d7faf"
SRC_URI[split_noncore_tools_calculator.sha256sum] = "848c73af73fa2ba48c930e2c50fb2d6db6209aed1d0d3e1df6bdcc806f5b22a8"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_etc.md5sum] = "74ef523ef12e242155bbb745072434d9"
SRC_URI[split_etc.sha256sum] = "eef55ea2248b4f45f3a07beb6012e431dd71d4eefa134d39cc50b4d194c53087"
