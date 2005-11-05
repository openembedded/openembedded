DESCRIPTION = "Todo list manager"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-pics"
APPNAME = "todolist"


S = "${WORKDIR}/todo"

inherit opie

# FILES plugins/application/libtodolist.so* bin/todolist apps/1Pim/todo.desktop
