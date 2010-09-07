require clutter-box2d.inc

PR = "${INC_PR}.0"

SRC_URI = "http://source.clutter-project.org/sources/clutter-box2d/0.10/clutter-box2d-${PV}.tar.bz2 \
           file://introspection.diff \
           file://example-data-location.patch \
"

SRC_URI[md5sum] = "51618976ca6a5d536c4eac5f0e120d9d"
SRC_URI[sha256sum] = "1e42d0cea429e4dc953a1f652672dbd322b3938846e99bab35f463de6fd8ae7f"

