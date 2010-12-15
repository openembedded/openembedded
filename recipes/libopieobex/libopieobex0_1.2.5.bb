require libopieobex0.inc
PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_obex.tar.bz2;name=split_core_obex \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           file://disable-bt-check.patch"
SRC_URI[split_core_obex.md5sum] = "9fff83489fa298d5fe0b698936eb6a8d"
SRC_URI[split_core_obex.sha256sum] = "e92b9d37ef2c4de2f9264eaa4ee59a56fc710bf6cd0c22cdc117d855d5379c5a"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
