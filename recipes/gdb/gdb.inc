require gdb-common.inc

DEFAULT_PREFERENCE_avr32 = "-99"

DEPENDS = "ncurses readline zlib flex-native bison-native"

PACKAGES =+ "gdbserver"
FILES_gdbserver = "${bindir}/gdbserver"

RRECOMMENDS_gdb_append_libc-glibc = " glibc-thread-db "
RRECOMMENDS_gdb_append_libc-uclibc = " uclibc-thread-db "

inherit gettext

SRC_URI += "file://kill_arm_map_symbols.patch \
            file://gdbserver-cflags-last.diff;striplevel=0"
#FIXME	   file://uclibc.patch \

EXTRA_OEMAKE = "'SUBDIRS=intl mmalloc libiberty opcodes bfd sim gdb etc utils'"

EXTRA_OECONF = "--disable-gdbtk --disable-tui --disable-x \
                --with-curses --disable-multilib --with-readline --disable-sim \
                --program-prefix='' --disable-lto"

LDFLAGS_append = " -s"
export CFLAGS_append=" -L${STAGING_LIBDIR}"

do_configure () {
	# override this function to avoid the autoconf/automake/aclocal/autoheader
	# calls for now
	(cd ${S} && gnu-configize) || die "failure in running gnu-configize"

	# Remove duplicate spaces to work around configure complaining about
	# changed LDFLAGS.
	LDFLAGS=$(echo "${LDFLAGS}" | sed "s/  / /")

        CPPFLAGS="" oe_runconf
}

do_install () {
	make -C bfd/doc chew LDFLAGS= CFLAGS=-O2
	oe_runmake DESTDIR='${D}' install
	install -d ${D}${bindir}
	install -m 0755 gdb/gdbserver/gdbserver ${D}${bindir}
}
