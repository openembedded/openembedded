require binutils.inc
require binutils-avr32.inc

INC_PR = "r7"
PR = "${INC_PR}.1"

SRC_URI = \
    "http://ftp.gnu.org/gnu/binutils/binutils-${PV}.tar.bz2 \
     file://better_file_error.patch;patch=1 \
     file://signed_char_fix.patch;patch=1 \
"

#patches from http://svn.uclibc.org/cgi-bin/viewcvs.cgi/trunk/buildroot/toolchain/binutils/2.17/

SRC_URI += "\
	file://100-uclibc-conf.patch;patch=1 \
	file://300-006_better_file_error.patch;patch=1 \
	file://702-binutils-skip-comments.patch;patch=1 \
	file://110-arm-eabi-conf.patch;patch=1 \
	file://300-012_check_ldrunpath_length.patch;patch=1 \
	file://300-001_ld_makefile_patch.patch;patch=1 \
	file://400-mips-ELF_MAXPAGESIZE-4K.patch;patch=1 \
"
# removed in favor of the atmel 1.2.6 patch which is supposedly newer (yes)
#        file://500-avr32-atmel.1.3.0.patch;patch=1 \
#        file://501-avr32-fix-pool-alignment.patch;patch=1 \

SRC_URI_append_avr32 = "\
        file://binutils-2.17.atmel.1.2.6.patch.bz2;patch=1 \
"

# Zecke's OSX fixes
SRC_URI += " file://warning-free.patch;patch=1 "

SRC_URI[md5sum] = "e26e2e06b6e4bf3acf1dc8688a94c0d1"
SRC_URI[sha256sum] = "e2c33ce6f23c9a366f109ced295626cb2f8bd6b2f08ff9df6dafb5448505a25e"
