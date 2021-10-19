package com.gqz.chapter9;

import com.gqz.chapter9.dao.UsersDao;
import com.gqz.chapter9.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class FindAllUsersTest{
	public static void main(String[] args) {
		//创建一个名称为usersDao的对象
		UsersDao usersDao = new UsersDao();
		//将UsersDao对象的findAll()方法执行后的结果放入list集合
		List<User> list = null;
		try {
			list = usersDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//循环输出集合中的数据
		if (list != null) {
			list.forEach(user -> {
				System.out.println("name:" + user.getUsername()+"\n"+
						"password:"+user.getPassword()+"\n"+
						"nickname:"+user.getNickname()+"\n"+
						"gender:"+user.getGender()+"\n"+
						"address:"+user.getAddress()+"\n"+
						"email:"+user.getEmail()+"\n");
				System.out.println("\n\t");
			});
		}else {
			System.out.println("查找的用户为空！\n" +
					"要想清楚, 随机一段废话, 到底是一种怎么样的存在. 了解清楚随机一段废话到底是一种怎么样的存在, 是解决一切问题的关键.问题的关键究竟为何? 这种事实对本人来说意义重大, 相信对这个世界也是有一定意义的.这样看来, 雷锋曾经提到过, 自己活着，就是为了使别人过得更美好。这似乎解答了我的疑惑. \n" +
					"了解清楚随机一段废话到底是一种怎么样的存在, 是解决一切问题的关键.\n" +
					"总结的来说, 非洲曾经提到过, 最灵繁的人也看不见自己的背脊。这句话看似简单，但其中的阴郁不禁让人深思. 随机一段废话, 到底应该如何实现. 随机一段废话的发生, 到底需要如何做到, 不随机一段废话的发生, 又会如何产生. 本人也是经过了深思熟虑,在每个日日夜夜思考这个问题. 在这种困难的抉择下, 本人思来想去, 寝食难安.生活中, 若随机一段废话出现了, 我们就不得不考虑它出现了的事实. 在这种困难的抉择下, 本人思来想去, 寝食难安.迈克尔·F·斯特利说过一句著名的话, 最具挑战性的挑战莫过于提升自我。这不禁令我深思. 经过上述讨论, \n" +
					"这样看来, \n" +
					"经过上述讨论, 在这种不可避免的冲突下，我们必须解决这个问题. 屠格涅夫曾经说过, 你想成为幸福的人吗？但愿你首先学会吃得起苦。这启发了我. 这种事实对本人来说意义重大, 相信对这个世界也是有一定意义的.既然如此, 随机一段废话, 发生了会如何, 不发生又会如何. 随机一段废话的发生, 到底需要如何做到, 不随机一段废话的发生, 又会如何产生. 所谓随机一段废话, 关键是随机一段废话需要如何写. 一般来讲, 我们都必须务必慎重的考虑考虑. 我们都知道, 只要有意义, 那么就必须慎重考虑.总结的来说, 问题的关键究竟为何? 随机一段废话, 发生了会如何, 不发生又会如何. 每个人都不得不面对这些问题. 在面对这种问题时, 这种事实对本人来说意义重大, 相信对这个世界也是有一定意义的.对我个人而言，随机一段废话不仅仅是一个重大的事件，还可能会改变我的人生. 要想清楚, 随机一段废话, 到底是一种怎么样的存在. 现在, 解决随机一段废话的问题, 是非常非常重要的. 所以, 这样看来, 我们不得不面对一个非常尴尬的事实, 那就是, 我认为, 生活中, 若随机一段废话出现了, 我们就不得不考虑它出现了的事实. 随机一段废话因何而发生?这样看来, 随机一段废话, 到底应该如何实现. ");
		}

		}
}
