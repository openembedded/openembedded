# common functions for all clutter-libraries

# all .debug stuff goes to clutter*-dbg
FILES_${PN}-dbg += "${bindir}/.debug"

# helper for (git)-recipes which do not have gtk-doc.make
copy_gtk_doc_make() {
	if [ -e ${WORKDIR}/gtk-doc.make ] ; then
		cp ${WORKDIR}/gtk-doc.make ${S}/gtk-doc.make
	else
		touch ${S}/gtk-doc.make
	fi
}

# clutter packs assume building and target are the same
# for us they are definitely not
make_all_execs_installable() {
	for i in $(find ${S} -name Makefile.am) ; do
		sed -i -e s:noinst_PROGRAMS:bin_PROGRAMS:g $i
	done
}

#check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
def get_clutter_fpu_setting(bb, d):
	if bb.data.getVar('TARGET_FPU', d, 1) in [ 'soft' ]:
		return "--without-fpu"
	return ""

