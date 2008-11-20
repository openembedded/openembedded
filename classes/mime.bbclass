DEPENDS += "shared-mime-info-native shared-mime-info"

mime_postinst() {
if [ "$1" = configure ]; then
	update-mime-database $D${datadir}/mime
fi
}

mime_prerm() {
if [ "$1" = remove ] || [ "$1" = upgrade ]; then
    update-mime-database $D${datadir}/mime
fi
}

python populate_packages_append () {
	import os.path, re
	packages = bb.data.getVar('PACKAGES', d, 1).split()
	workdir = bb.data.getVar('WORKDIR', d, 1)
	
	for pkg in packages:
		mime_dir = '%s/install/%s/usr/share/mime/packages' % (workdir, pkg)
		mimes = []
		mime_re = re.compile(".*\.xml$")
		if os.path.exists(mime_dir):
			for f in os.listdir(mime_dir):
				if mime_re.match(f):
					mimes.append(f)
		if mimes != []:
			bb.note("adding mime postinst and prerm scripts to %s" % pkg)
			postinst = bb.data.getVar('pkg_postinst_%s' % pkg, d, 1) or bb.data.getVar('pkg_postinst', d, 1)
			if not postinst:
				postinst = '#!/bin/sh\n'
			postinst += bb.data.getVar('mime_postinst', d, 1)
			bb.data.setVar('pkg_postinst_%s' % pkg, postinst, d)
			prerm = bb.data.getVar('pkg_prerm_%s' % pkg, d, 1) or bb.data.getVar('pkg_prerm', d, 1)
			if not prerm:
				prerm = '#!/bin/sh\n'
			prerm += bb.data.getVar('mime_prerm', d, 1)
			bb.data.setVar('pkg_prerm_%s' % pkg, prerm, d)

}
