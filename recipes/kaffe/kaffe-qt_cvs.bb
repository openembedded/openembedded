BROKEN = "1"

SRCDATE = "20060814"
PV = "1.1.4+cvs${SRCDATE}"
SRC_URI = "cvs://readonly:readonly@cvs.kaffe.org/cvs/kaffe;module=kaffe"
S = "${WORKDIR}/kaffe"

require kaffe.inc

DEPENDS += "libqpe-opie"

CXXFLAGS += " -DQPE "
EXTRA_OEMAKE += "MOC=${STAGING_BINDIR_NATIVE}/moc"
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
