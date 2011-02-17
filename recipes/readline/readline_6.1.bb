DESCRIPTION = "The GNU Readline library provides a set of functions for use by applications that allow users to edit \
command lines as they are typed in. Both Emacs and vi editing modes are available. The Readline library includes  \
additional functions to maintain a list of previously-entered command lines, to recall and perhaps reedit those   \
lines, and perform csh-like history expansion on previous commands."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv3+"
DEPENDS = "ncurses"
LEAD_SONAME = "libreadline.so"

PV = "6.1+p2"
FILESPATHPKG =. "${BPN}-6.1:"
PR = "r2"

# Don't bring it in silently because there was a switch from GPLv2
# to GPLv3.  It might require newer ncurses 5.7 too which are not
# preferred by default.
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GNU_MIRROR}/readline/readline-6.1.tar.gz;name=tarball \
  ${GNU_MIRROR}/readline/readline-6.1-patches/readline61-001;striplevel=0;name=patch001;apply=yes \
  ${GNU_MIRROR}/readline/readline-6.1-patches/readline61-002;striplevel=0;name=patch002;apply=yes \
  file://libs.patch \
  file://acinclude.m4"
S = "${WORKDIR}/${BPN}-6.1"

EXTRA_OECONF = "--with-curses --enable-multibyte"

inherit autotools

PACKAGES += "${PN}-examples"

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-examples = "${datadir}/readline/*.c"


do_configure_prepend () {
    install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

BBCLASSEXTEND = "native"

##############

SRC_URI[tarball.md5sum] = "fc2f7e714fe792db1ce6ddc4c9fb4ef3"
SRC_URI[tarball.sha256sum] = "f0caf608c06ccd6d56b3bee1843458d509c53f9b53dffffe07cc11d8f03fa969"

SRC_URI[patch001.md5sum] = "c642f2e84d820884b0bf9fd176bc6c3f"
SRC_URI[patch001.sha256sum] = "9adbc791c0b76d4f161623ad9e4a5938d763bf4067d59d180312d620d7c94dde"

SRC_URI[patch002.md5sum] = "1a76781a1ea734e831588285db7ec9b1"
SRC_URI[patch002.sha256sum] = "a19519cd56bf3c55d2ce226b70bae1a962ff0f40e2478d090dd12b6624c23d62"
