DESCRIPTION = "The Audio File Library provides a uniform and elegant \
API for accessing a variety of audio file formats, such as AIFF/AIFF-C, \
WAVE, NeXT/Sun .snd/.au, Berkeley/IRCAM/CARL Sound File, Audio Visual \
Research, Amiga IFF/8SVX, and NIST SPHERE."
SECTION = "libs"
LICENSE = "LGPL GPL"
RPROVIDES_${PN} += "audiofile"
PR = "r8"

SRC_URI = "http://www.68k.org/~michael/audiofile/audiofile-${PV}.tar.gz \
	   file://audiofile-m4_quote_fix.diff;patch=1;pnum=0 \
	   file://audiofile-oldstyle.patch;patch=1;pnum=0 \
	   file://audiofile-0.2.6.patch;patch=1;pnum=0 \
	   file://CVE-2008-5824.patch;patch=1 \
"

inherit autotools_stage lib_package binconfig
