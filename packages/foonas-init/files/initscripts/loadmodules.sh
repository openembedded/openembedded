#!/bin/sh

. /etc/default/modulefunctions # Load module loading logic

loadnetmods

loaddiskmods

loadmiscmods

exit 0
