//println(Jenkins.instance.metaClass.methods.name.sort().unique())
//Jenkins.instance.getJobNames()


jobs = ["buildable":[],"nonbuildable":[]]

for (item in Hudson.instance.items)
{
  if(!item.name.contains("Admin")) //omit com.cloudbees.hudson.plugins.folder.Folder
  {
    if(!item.buildable)
    {
      //println(item.name + " " + "\"" + item.lastBuild + "\"");
      if(item.lastBuild != null && item.lastBuild.time != "")
      {
        println(item.name + " " + item.lastBuild.time);
        jobs["buildable"].add(item.name)
      }
      else
      {
        println(item.name + " " + "Never Built")
        jobs["nonbuildable"].add(item.name)
      }

    }
  }
}
println("===========buildable jobs============")
for (job in jobs["buildable"])
{
    println(job)
}

println("=============nonbuildable jobs===============")

for (job in jobs["nonbuildable"])
{
    println(job)
}