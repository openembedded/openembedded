DESCRIPTION = "The RPM Package Manager."
HOMEPAGE = "http://rpm.org/"
LICENSE = "LGPL GPL"
DEPENDS = "python-native"
PR = "r16"

SRC_URI = "http://www.rpm.org/releases/rpm-4.4.x/rpm-4.4.2.3.tar.gz \
           file://external-tools.patch;patch=1 \
	   file://cross_libpaths.patch;patch=1 \
	   file://rpmconfigdir.patch;patch=1 \
	   file://weakdeps.patch;patch=1;pnum=0 \
	   file://tagsbackport.patch;patch=1;pnum=0 \
	   file://missingok.patch;patch=1;pnum=0 \
	   file://extcond.patch;patch=1;pnum=0"

inherit autotools python-dir

S = "${WORKDIR}/rpm-${PV}"

ARM_INSTRUCTION_SET = "arm"

acpaths = "-I ${S}/db/dist/aclocal -I ${S}/db/dist/aclocal_java"

PACKAGES += "python-rpm"
FILES_python-rpm = "${PYTHON_SITEPACKAGES_DIR}/rpm/_*"
RDEPENDS_python-rpm += "${PN} python-core"

# Handle the db MUTEX settings here, the POSIX library is
# the default - "POSIX/pthreads/library".
# Don't ignore the nice SWP instruction on the ARM:
# These enable the ARM assembler mutex code, this won't
# work with thumb compilation...
ARM_MUTEX = "--with-mutex=ARM/gcc-assembly"
MUTEX = ""
MUTEX_arm = "${ARM_MUTEX}"
MUTEX_armeb = "${ARM_MUTEX}"
EXTRA_OECONF += "${MUTEX}"

export varprefix = "${localstatedir}"

do_configure_prepend (){
	EXTRA_RPM_OECONF="--with-python \
	--with-python-incdir=${STAGING_INCDIR}/${PYTHON_DIR} \
	--with-python-libdir=${libdir}/${PYTHON_DIR} \
	--without-apidocs \
	--without-selinux \
	--without-lua \
	--without-dmalloc \
	--without-efence"
}

do_configure () {
	rm ${S}/popt/ -Rf
	rm ${S}/db/dist/configure.in -f
	cd ${S}/db/dist/aclocal
	rm libtool* -f
	for i in `ls *.ac`; do
	    j=`echo $i | sed 's/.ac/.m4/g'`
	    mv $i $j
	done
	cd ${S}/db/dist/aclocal_java
	for i in `ls *.ac`; do
	    j=`echo $i | sed 's/.ac/.m4/g'`
	    mv $i $j
	done
	cd ${S}
	autotools_do_configure ${EXTRA_RPM_OECONF}
	cd ${S}/db/dist
	. ./RELEASE
	# Edit version information we couldn't pre-compute.
	sed -i -e "s/__EDIT_DB_VERSION_MAJOR__/$DB_VERSION_MAJOR/g"  configure
	sed -i -e "s/__EDIT_DB_VERSION_MINOR__/$DB_VERSION_MINOR/g"  configure
	sed -i -e "s/__EDIT_DB_VERSION_PATCH__/$DB_VERSION_PATCH/g"  configure
	sed -i -e "s/__EDIT_DB_VERSION_STRING__/$DB_VERSION_STRING/g"  configure
	sed -i -e "s/__EDIT_DB_VERSION_UNIQUE_NAME__/$DB_VERSION_UNIQUE_NAME/g"  configure
	sed -i -e "s/__EDIT_DB_VERSION__/$DB_VERSION/g"  configure
	cd ${S}/db3
	${S}/db3/configure \
		    --build=${BUILD_SYS} \
		    --host=${HOST_SYS} \
		    --target=${TARGET_SYS} \
		    --prefix=${prefix} \
		    --exec_prefix=${exec_prefix} \
		    --bindir=${bindir} \
		    --sbindir=${sbindir} \
		    --libexecdir=${libexecdir} \
		    --datadir=${datadir} \
		    --sysconfdir=${sysconfdir} \
		    --sharedstatedir=${sharedstatedir} \
		    --localstatedir=${localstatedir} \
		    --libdir=${libdir} \
		    --includedir=${includedir} \
		    --oldincludedir=${oldincludedir} \
		    --infodir=${infodir} \
		    --mandir=${mandir} \
		    ${EXTRA_RPM_OECONF} \
		    --with-pic
}
