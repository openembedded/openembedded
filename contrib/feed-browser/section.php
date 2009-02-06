<?php

/*
 * (c) Koen Kooi 2006, 2007, 2008, 2009
 * (c) Marcin Juszkiewicz 2006, 2007
 *
 * This php script is intended to do the following:
 *
 * - have searchable webfronted for the feed like packages.ubuntu.com
 *
 * ToDo:
 *
 * - search functionality
 * - provide feed-management functionality
 * - allow uploading of new software
 *
 *
 * This program is free software; you can redistribute it and/or  modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License.
 * 
 * This program is distributed in the hope that it will be useful,  but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public License along
 * with this library; see the file COPYING.LIB.  If not, write to the Free
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307,
 * USA.
 *
 */

require_once 'includes/config.inc';
require_once 'includes/functions.inc';

if(!check_database())
{
	die("Database not found and cannot be created.");
}

if (isset($_POST["action"]) && $_POST["action"] != "") {
	$action = $_POST["action"];
} else {
	print "Invalid action: $action";
	exit;
}

if (isset($_POST["pkgsearch"]) && $_POST["pkgsearch"] != "") {
        $pkgsearch = $_POST["pkgsearch"];
}

if (isset($_POST["section"]) && $_POST["section"] != "") {
        $section = $_POST["section"];
}

if (isset($_POST["arch"]) && $_POST["arch"] != "") {
        $arch = $_POST["arch"];
} else {
	$arch = "";
}

if (isset($_POST["pkgname"]) && $_POST["pkgname"] != "") {
        $pkgname = $_POST["pkgname"];
}


//print("$action");
switch($action) {
case "sectionslist":
				echo sectionslist();
				break;
case "searchletter":				
				echo searchletter(); 
				break;
case "pkgquery":
				echo searchpkg("%{$pkgsearch}%", $arch);
				break;
case "pkgname":
				echo pkgdetails($pkgname);
				break;
case "section":
				echo searchsection($section);
				break;
} 
?>
