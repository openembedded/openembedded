require cairo.inc

DEPENDS = "cairo libsigc++-2.0"
DESCRIPTION = "C++ bindings for Cairo graphics library"

SRC_URI = "http://cairographics.org/releases/cairomm-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "559afbc47484ba3fad265e38a3dafe90"
SRC_URI[archive.sha256sum] = "a28ec6d9af8f93d09076f32cd77de35f9d74a517def5dea12cb8cc2ce3a6c8f1"

