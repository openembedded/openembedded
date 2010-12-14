require libopieobex0.inc
PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_obex.tar.bz2;name=split_core_obex \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           file://disable-bt-check.patch"
SRC_URI[split_core_obex.md5sum] = "9bc63da4a65eb809af939103a6c6843d"
SRC_URI[split_core_obex.sha256sum] = "f86699f5f6b30daa9b170bc77e0dfdc6873ea46d3b68b7f7d9747c043443b319"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
