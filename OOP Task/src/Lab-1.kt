abstract class Employee (
    var firstname: String,
    var secondname: String,
    var exp: Int,
    var base_sal : Double
){
    open fun giveSalary(): Double {
        while (exp in 3..5) return base_sal + 200.0
        while (exp > 5) return base_sal * 1.2 + 500.0
        return base_sal
    }
}

class Manager(
    firstname: String,
    secondname: String,
    exp: Int,
    base_sal: Double,
    var Team: MutableList<Employee> = mutableListOf()
): Employee(firstname,secondname, exp, base_sal) {
    override fun giveSalary(): Double {
        var Dev_Count = Team.filterIsInstance<Developer>().count()
        var Des_Count = Team.filterIsInstance<Designer>().count()
        var TeamCount =  Des_Count + Dev_Count
        while (TeamCount in 6..10)  return super.giveSalary() + 200.0
        while (TeamCount > 10) return super.giveSalary() + 300.0
        while (Dev_Count > TeamCount/2) return super.giveSalary() * 1.1
        return super.giveSalary()
    }
}

class Designer (
    firstname: String,
    secondname: String,
    exp: Int,
    base_sal : Double,
    var coef: Double
) : Employee(firstname,secondname, exp, base_sal){
    override fun giveSalary() : Double{
        return super.giveSalary() * coef
    }
}

class Developer (
    firstname: String,
    secondname: String,
    exp: Int,
    base_sal: Double
) : Employee(firstname,secondname,exp,base_sal)

class Department(
    var managers: MutableList<Manager> = mutableListOf()
){
    fun giveSallaryAll(){
        managers.forEach{manager -> manager.giveSalary()
        manager.Team.forEach{employee -> employee.giveSalary()}}
    }
}

fun main() {
    //----------------- 1st-Team -----------------------//
    val dev1 = Developer("Oleksandr", "Burda", 2, 35.0)
    val dev2 = Developer("Alex", "Kushi", 15, 60.0)
    val dev3 = Developer("Serhio", "Kostelico", 20, 70.0)
    val dev4 = Developer("Artem", "Jirkov", 5, 40.0)
    val des1 = Designer("Pavel", "Ostrevic", 3, 150.0, 0.5)
    val des2 = Designer("Kano", "Shmitd", 6, 160.0, 0.7)
    val manager1 = Manager("Jinder", "Mustafa", 5, 350.0)
    manager1.Team.add(dev1)
    manager1.Team.add(dev2)
    manager1.Team.add(dev3)
    manager1.Team.add(dev4)
    manager1.Team.add(des2)
    manager1.Team.add(des1)

    //----------------- 2nd-Team -----------------------//
    val dev5 = Developer("Alex","Browne", 4, 35.0)
    val dev6 = Developer("Sanna","Joyner", 20, 65.0)
    val dev7 = Developer("Hisham", "Forster", 2, 30.0)
    val des3 = Designer("Carson", "Walter", 4, 145.0, 0.6)
    val des4 = Designer("Beau", "Stott", 3, 155.0, 0.5)
    val des5 = Designer("Clarissa", "Gilmore", 3, 140.0, 0.45)
    val manager2 = Manager("Delores", "Bloom", 7, 390.0)
    manager2.Team.add(dev5)
    manager2.Team.add(dev6)
    manager2.Team.add(dev7)
    manager2.Team.add(des3)
    manager2.Team.add(des4)
    manager2.Team.add(des5)

    //----------------- giveSallary -------------------------//
    val department = Department()
    department.giveSallaryAll()
    println(dev1.firstname + " " + dev1.secondname + " got salary: " + dev1.giveSalary())
    println(dev2.firstname + " " + dev2.secondname + " got salary: " + dev2.giveSalary())
    println(dev3.firstname + " " + dev3.secondname + " got salary: " + dev3.giveSalary())
    println(dev4.firstname + " " + dev4.secondname + " got salary: " + dev4.giveSalary())
    println(dev5.firstname + " " + dev5.secondname + " got salary: " + dev5.giveSalary())
    println(dev6.firstname + " " + dev6.secondname + " got salary: " + dev6.giveSalary())
    println(dev7.firstname + " " + dev7.secondname + " got salary: " + dev7.giveSalary())
    println(des1.firstname + " " + des1.secondname + " got salary: " + des1.giveSalary())
    println(des2.firstname + " " + des2.secondname + " got salary: " + des2.giveSalary())
    println(manager1.firstname + " " + manager1.secondname + " got salary: " + manager1.giveSalary())
    println(manager2.firstname + " " + manager2.secondname + " got salary: " + manager2.giveSalary())
}