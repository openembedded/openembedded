# Forcing build all rdepends
do_mamona[nostamp] = "1"
do_mamona[recrdeptask] = "do_package_write"
addtask mamona before do_build after do_install
