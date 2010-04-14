SRC_URI = "http://www.opensync.org/attachment/wiki/download/msynctool-0.22.tar.bz2?format=raw"

LICENSE = "GPL"
DEPENDS = "libopensync"
HOMEPAGE = "http://www.opensync.org/"

inherit autotools pkgconfig

require opensync-unpack.inc

SRC_URI[md5sum] = "3ddc55209e682a8b99a47cf3d0053dbf"
SRC_URI[sha256sum] = "5a3008eaaf61dc9f7cc0cd0c762d700dfa8cc1aa65c07ec5bf12abe252f2d280"
