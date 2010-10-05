SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           file://glamo.patch \
          "

SRC_URI[archive.md5sum] = "82c740c49d572baa6da2b1a1eee90bca"
SRC_URI[archive.sha256sum] = "e0cd67f4516d809e18fbc85dc721e84217d524d77d815b59e0c7c2d7ea1129f3"

EXTRA_OECONF += " --disable-gallium"
