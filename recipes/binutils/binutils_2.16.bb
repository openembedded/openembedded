PR = "r10"

SRC_URI = \
    "${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://ld_makefile.patch \
     file://better_file_error.patch \
     file://signed_char_fix.patch \
     file://binutils-2.16-objcopy-rename-errorcode.patch \
     file://binutils-100_cflags_for_build.patch"

# uclibc patches
SRC_URI += "file://binutils-2.16-linux-uclibc.patch"

# arm thumb support patches
SRC_URI += "file://binutils-2.16-thumb-trampoline.patch"
SRC_URI += "file://binutils-2.16-thumb-glue.patch"

# powerpc patches
SRC_URI += "file://binutils-2.16.1-e300c2c3.patch"

require binutils.inc
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "bcb9fabaf0eaf91bd38c4ee148658df8"
SRC_URI[sha256sum] = "5645c3371aac47cbbcc1354eab10ec32777837d7cb4ba47b94c9043612b12f36"
