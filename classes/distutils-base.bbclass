DEPENDS  += "${@["python-native python", ""][(bb.data.getVar('PACKAGES', d, 1) == '')]}"
RDEPENDS += "${@['', 'python-core']['${PN}' == '${BPN}']}"

inherit distutils-common-base
