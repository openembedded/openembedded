require cairo.inc

PR = "r3"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz;name=cairo \
           file://dolt-fix.patch \
           file://0001-Rely-less-on-DP-FPU-for-common-matrix-test-funcs.patch \
"

SRC_URI[cairo.md5sum] = "b60a82f405f9400bbfdcf850b1728d25"
SRC_URI[cairo.sha256sum] = "572bada15596ec8708392db1af8b93a1af75ca47690348154e2841f3a6f08439"

