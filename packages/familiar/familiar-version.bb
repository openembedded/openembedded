PACKAGE_ARCH = "all"

def get_sanitized_version(s):

	max_version_component = "99"
	rc_separator = "-rc"

	if not rc_separator in s:
		return s

	version = s.split(rc_separator)[0][1:]
	vcomps = version.split(".")
	vcomps.reverse()

	vcomps_new = []
	done = False
	for i in vcomps:
		if done:
			vcomps_new.insert(0, i)
			continue
		if int(i) < 1:
			vcomps_new.insert(0, max_version_component)
			continue
		vcomps_new.insert(0, "%i" % (int(i) - 1))
		done = True

	return "v" + ".".join(vcomps_new) + "+" +  s.replace("-", "")

PV = "${@get_sanitized_version(bb.data.getVar('DISTRO_VERSION', d, 1))}"

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "Familiar ${DISTRO_VERSION}" > ${D}${sysconfdir}/familiar-version
}
