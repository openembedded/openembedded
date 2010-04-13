SECTION = "base"
do_unpack[depends] += "unzip-native:do_populate_staging"

SRC_URI = "http://hauppauge.lightpath.net/de/nova-pci218c.exe"
FILES_${PN} = '*'

python do_unpack() {
	import re

	localdata = bb.data.createCopy(d)
	overrides = bb.data.getVar('OVERRIDES', localdata, 1)
	if not overrides:
		raise bb.build.FuncFailed('OVERRIDES not defined')
	bb.data.setVar('OVERRIDES', overrides+':'+bb.data.getVar('PN', localdata, 1), localdata)

	bb.data.update_data(localdata)

	src_uri = bb.data.getVar('SRC_URI', localdata)
	if not src_uri:
		return
	src_uri = bb.data.expand(src_uri, localdata)

	local = bb.data.expand(bb.fetch.localpath(src_uri, localdata), localdata)
	# dont need any parameters for extraction, strip them off
	local = re.sub(';.*$', '', local)
	bindir = bb.data.getVar('STAGING_BINDIR_NATIVE', localdata, 1)
	cmd = '%s/unzip %s' % (bindir, local)
	if not os.path.exists(bb.data.getVar('S', localdata, 1)):
		os.mkdir(bb.data.getVar('S', localdata, 1))
	os.chdir(bb.data.getVar('S', localdata, 1))
	bb.note("Unpacking %s to %s/" % (local, os.getcwd()))
	ret = os.system(cmd)
}

do_install() {
	install -d ${D}${prefix}/lib/hotplug/firmware
	install -m 0644 software/OEM/PCI/App/ttlcdacc.dll ${D}${prefix}/lib/hotplug/firmware/tda1004x.bin
}

SRC_URI[md5sum] = "139a1ed50a1a12e47b1f7deedf4f40c3"
SRC_URI[sha256sum] = "4310a3a526ae5461e17f57353fc29f71d13820a215eaa62c629190cc2a026173"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "c4c751d8a79f6701fda4a1813c5d5823"
#SRC_URI[sha256sum] = "c5c54c57745cdf2390959e33f2cd44b87370f18b217f12de195d9f2de1c07b22"
