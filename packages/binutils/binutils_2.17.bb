require binutils.inc

PR = "r1"

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
        http://avr32linux.org/twiki/pub/Main/DevelopmentTools/500-avr32.patch.gz;patch=1 \
        http://avr32linux.org/twiki/pub/Main/DevelopmentTools/501-avr32-sreldyn-fix.patch.gz;patch=1 \
	http://avr32linux.org/twiki/pub/Main/DevelopmentTools/502-avr32-bfd-dont-allow-direct-refs-to-bss.patch.gz;patch=1 \
"

# Zecke's OSX fixes
SRC_URI += " file://warning-free.patch;patch=1 "
