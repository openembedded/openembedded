BROKEN = "1"

PV = "1.1.4+cvs${SRCDATE}"
SRC_URI = "cvs://readonly:readonly@cvs.kaffe.org/cvs/kaffe;module=kaffe"
S = "${WORKDIR}/kaffe"

include kaffe.inc

DEPENDS += "libqpe-opie"

CXXFLAGS += " -DQPE "
EXTRA_OEMAKE += "MOC=${STAGING_BINDIR}/moc"
EXTRA_OECONF += " --with-qtdir=$QTDIR \
	--with-awt=qt \
	--enable-pure-java-math \
	--without-x \
	--without-classpath-gtk-awt \
	--without-kaffe-x-awt \
	--with-kaffe-qt-awt"

do_configure_prepend() {
	rm -f m4/libtool.m4
}
