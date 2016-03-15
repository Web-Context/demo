[![DockUnit (linux) Build status](http://dockunit.io/svg/Web-Context/demo?master)](https://dockunit.io/projects/Web-Context/demo "DockUnit (linux) Build status")
[![AppVeyor (win32) Build status](https://ci.appveyor.com/api/projects/status/vxbccc1t9ceadhi9)](https://ci.appveyor.com/project/Web-Context/demo "AppVeyor (win32) Build status")
[![Travis-CI (linux) Build Status](https://travis-ci.org/Web-Context/demo.png?branch=master)](https://travis-ci.org/Web-Context/demo "Travis-CI (linux) Build Status")


DEMO
====


Some technical demo around multiple technologies.

- Blog: an HTML5+AngularJS smart designed blog with no input page, only reading; just testing some design.

```bash
$> cd blog
$> grunt serve
```

- DaBlog: another blog but thid time built with the yeoman generator (see [yeoman.io](http://yeoman.io "Visit the home of Sir Yeoman !"))

```bash
$> cd dablog/yo
$> grunt serve
$> cd ..
$> mvn spring-boot:run -Pmongodb
```

Using this "mongodb" maven profile, you will activate an embedded Mongodb database to serve DaBlog application.

Anyway here is the last design for the angularyo project :

<a href="./docs/images/posts_games_preview.png"><img title="First preview of Blog Design" src="./docs/images/posts_games_preview.png" style="width:350px; box-shadow:4px 4px 8px #666;"/></a>

Have Fun !


[http://web-context.github.io](http://web-context.github.io "visit home of these demo")

McG.
